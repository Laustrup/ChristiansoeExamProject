async function headAndHeaderTitles() {
    let id = sessionStorage.getItem("locationId")

    const response = await fetch("http://localhost:8080//location/" + id)
    const data = await response.json()

    document.getElementById("location_title").innerHTML = `<title>data.title</title>`

}