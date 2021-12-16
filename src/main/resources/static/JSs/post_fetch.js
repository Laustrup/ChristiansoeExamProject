getPost()
async function getPost() {
    let id = sessionStorage.getItem("locationId")

    const response = await fetch("http://localhost:8080/location/" + id)
    const data = await response.json()

    document.getElementById("Title").innerText = data.title
    document.getElementById("Report").innerText = data.report

    let imageHtml = ``

    for(let i = 0; i < data.images.length; i++){
        imageHtml +=
            `<div class="imageItem">
                <h1>${data.images[i].title}</h1>
                <img src="../../../static/${data.images[i].filePath}" alt="Couldn't show image">
            </div>`
    }


    let soundHtml = ``
    for(let i = 0; i < data.sounds.length; i++){
        soundHtml +=

            `<div class="soundItem">
                <h1>${data.sounds[i].title}</h1>
                <audio controls>
                    <source src="../../../static/${data.sounds[i].filePath}" type="audio/wav">
                </audio>
            </div>`
    }

    document.getElementById("Images").innerHTML = imageHtml
    document.getElementById("Sounds").innerHTML = soundHtml

    console.log(data)
}