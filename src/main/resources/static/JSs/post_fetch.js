
getPost()
async function getPost() {
    let id = sessionStorage.getItem("locationId")

    const response = await fetch("http://localhost:8080/location/" + id)
    const data = await response.json()

    setUpPostHeader(data)
    setUpSoundHtml(data)
    setUpImageHtml(data)
    setUpAnimalHtml(data)
}

function setUpPostHeader(data){
    document.getElementById("Title").innerText = data.title
    document.getElementById("Report").innerText = data.report
}

function setUpSoundHtml(data){

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
    document.getElementById("Sounds").innerHTML = soundHtml

}

function setUpImageHtml(data){

    let imageHtml = ``

    for(let i = 0; i < data.images.length; i++){
        imageHtml +=
            `<div class="imageItem">
                <h1>${data.images[i].title}</h1>
                <img src="../../../static/${data.images[i].filePath}" alt="Couldn't show image">
            </div>`
    }

    document.getElementById("Images").innerHTML = imageHtml
}

function setUpAnimalHtml(data){
    let animalHtml = ``
    for(let i = 0; i < data.animals.length; i++){
        animalHtml +=
            `<div class="animalItem">
            <div class="animalHeader">
            <h1>${data.animals[i].title}</h1>
            <p>${data.animals[i].report}</p>
            </div>
            <div class="animalContent">
            <div class="animalImages">`

        for(let j = 0; j < data.animals[i].images.length; j++){
            animalHtml +=
                `<img src="../../../static/${data.animals[i].images[j].filePath}"
                alt="Couldn't show image">`
        }

        animalHtml +=
            `</div>
            <div class="animalSounds">`

        for(let j = 0; j < data.animals[i].sounds.length; j++){

            animalHtml +=
                `<audio controls>
                    <source src="../../../static/${data.animals[i].sounds[j].filePath}" type="audio/wav">
                </audio>`
        }

        animalHtml +=
            `</div>
            </div>`
    }

    document.getElementById("Animals").innerHTML = animalHtml
}