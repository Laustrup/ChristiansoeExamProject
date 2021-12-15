
const map = createMap()
const routeCache = makeRouteCache()
setUpHandlers()


function createMap() {
    mapboxgl.accessToken = 'pk.eyJ1IjoiZ2Vvd2FsbCIsImEiOiJja3dvc28yeHkwNjBjMm9sMHB1NGlkdTJsIn0.-zQAF2T_9EOKLHEGnbUV4w';
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        center: [15.1877, 55.3203],
        zoom: 15,
        locale: 'Danish'
    })

    const bounds = [
        [15.1781, 55.3158],
        [15.1978, 55.3247]
    ];
    map.setMaxBounds(bounds);
    return map
}

function setUpHandlers() {
    document.getElementById("tourBtn").onclick = showTourChooser
    document.getElementById("tourChooserTable").onclick = selectTour
    document.getElementById("selectTourBtn").onclick = chooseTour
    document.getElementById("closeTourChooser").onclick = closeTourChooser
    document.getElementById("arrivedBtn").onclick = getNextTourPost
}

async function showTourChooser(){

    const response = await fetch("http://localhost:8080/tours")
    const data = await response.json()
    const tourList = []

    for(let i = 0; i < data.length; i++){
        tourList.push({
            title: data[i].title,
            description: data[i].report,
            id: data[i].id
        })
    }
    setUpTourListHTML(tourList)
    document.getElementById("tourChooser").style.display = "flex"
}

function selectTour(ev){
    let table = document.getElementById("tourChooserTable")
    let rowIndex = ev.target.parentElement.rowIndex - 1
    let maxRows = table.rows.length


    for(let i = 0; i < maxRows; i++){
        let row = document.getElementById("tour_" + i)
        if(i === rowIndex){
            row.style.backgroundColor = "dodgerblue"
            row.setAttribute("data-selected", "yes")
        }
        else{
            row.style.backgroundColor = "transparent"
            row.setAttribute("data-selected", "no")
        }
    }
}

function chooseTour(){
    let table = document.getElementById("tourChooserTable")
    let maxRows = table.rows.length

    for(let i = 0; i < maxRows; i++){
        let row = document.getElementById("tour_" + i)
        if(row.getAttribute("data-selected") === "yes") {
            let id = row.getAttribute("data-id")
            getTour(id)
            return
        }
    }
    alert("You need to select a tour")
}

function closeTourChooser(){
    document.getElementById("tourChooser").style.display = "none"
}

async function getNextTourPost(){
    routeCache.userArrived()
}

async function getTour(id){
    document.getElementById("tourChooser").style.display = "none"
    document.getElementById("loadingPrompt").style.display = "flex"

    const response = await fetch("http://localhost:8080/tour/" + id)
    const data = await response.json()

    await routeCache.saveTour(data)
    routeCache.getNextStep()

    document.getElementById("loadingPrompt").style.display = "none"
}

function setUpTourListHTML(tours){
    let finalHTML = generateTourListHTML(tours)

    let tableBody = document.getElementById("tourChooserTable")
    tableBody.innerHTML = finalHTML
}

function generateTourListHTML(tours){
    let finalHTML = ""
    for(let i = 0; i < tours.length; i++){
        let rowId = "tour_" + i
        finalHTML +=
            `<tr id=${rowId}  data-selected="no" data-id=${tours[i].id}>
                <td>${tours[i].title}</td>
                <td>${tours[i].description}</td>
            </tr>
            `
    }
    return finalHTML
}

async function getRouteData(start, end){
    const response = await fetch(`https://api.mapbox.com/directions/v5/mapbox/walking/
                ${start[0]},${start[1]};${end[0]},${end[1]}
                ?steps=true&geometries=geojson&access_token=${mapboxgl.accessToken}`
    )
    const json = await response.json()
    return json.routes[0]
}

function showRoute(data){
    const route = data.geometry.coordinates

    const geojson = {
        type: 'Feature',
        properties: {},
        geometry: {
            type: 'LineString',
            coordinates: route
        }
    }
    if (map.getSource('route')) {
        map.getSource('route').setData(geojson);
    }

    else {
        map.addLayer({
            id: 'route',
            type: 'line',
            source: {
                type: 'geojson',
                data: geojson
            },
            layout: {
                'line-join': 'round',
                'line-cap': 'round'
            },
            paint: {
                'line-color': '#3887be',
                'line-width': 5,
                'line-opacity': 0.75
            }
        });
    }
}

function makeRouteCache(){
    let routeList = []
    let currentStep
    return {
        saveTour: async (tour) => {
            currentStep = 0

            const locationsResponse = await fetch("http://localhost:8080/tourLocations/" + tour.id)
            const locations = await locationsResponse.json()

            const initialId = locations[0].id
            const initialStart = [15.186091, 55.320772]
            const initialEnd = [locations[0].longitude, locations[0].latitude]

            routeList[0] = await makeRouteObject(initialStart, initialEnd, initialId)

            for(let i = 1; i < locations.length; i++){
                const startLocation = locations[i-1]
                const startLocationCoordinates = [startLocation.longitude, startLocation.latitude]
                const endLocation = locations[i]
                const endLocationCoordinates = [endLocation.longitude, endLocation.latitude]
                const id = locations[i].id

                routeList[i] = await makeRouteObject(startLocationCoordinates, endLocationCoordinates, id)
            }
        },

        getNextStep: () => {

            if(currentStep >= routeList.length){
                routeList = []
                showEndText()
                return
            }

            const data = routeList[currentStep].data

            showRoute(data)
            showInstructions(data)
        },

        userArrived: () => {
            sessionStorage.setItem("locationId", routeList[currentStep].postId)
            window.open("http://localhost:8080/post", "_blank")
            currentStep++
            routeCache.getNextStep()
        }
    }
}

async function makeRouteObject(start, end, postId){
    const data = await getRouteData(start, end)
    return{
        start: start,
        end: end,
        data: data,
        postId: postId
    }
}

function showInstructions(data){
    const instructions = document.getElementById("instructions")
    const steps = data.legs[0].steps

    let tripInstructions = ""
    for (const step of steps) {
        tripInstructions += `<li>${step.maneuver.instruction}</li>`
    }

    let tourDuration = Math.floor(data.duration / 60)
    instructions.innerHTML =
        `<p><strong>Trip duration: ${tourDuration} min </strong></p>
        <ol>${tripInstructions}</ol>`
}

function showEndText(){
    const instructions = document.getElementById('instructions')
    instructions.innerHTML = `<p><strong>Turen er færdig. Vælg en ny?</strong></p>`
}