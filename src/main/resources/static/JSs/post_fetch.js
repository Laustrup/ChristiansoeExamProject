getPost()
function getPost(){
    let id = sessionStorage.getItem("locationId")

    fetch("http://localhost:8080/location?id=" + id)
        .then((response) => {
            return response.json()
        })
        .then((data) => {
            document.getElementById("Title").innerText = data.title
            document.getElementById("Report").innerText = data.report
            document.getElementById("Images").innerText = data.images
            document.getElementById("Sounds").dataset = data.sounds
            document.getElementById("Animals").dataset = data.animals
            console.log(data)
        })
}