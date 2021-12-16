getPost()
async function getPost() {
    let id = sessionStorage.getItem("locationId")

    const response = await fetch("http://localhost:8080/location/" + id)
    const data = await response.json()

    document.getElementById("Title").innerText = data.title
    document.getElementById("Report").innerText = data.report

    let imageHtml = `<ul>`

    for(let i = 0; i < data.images.length; i++){
        imageHtml += `<li><img src="../../../static/${data.images[i].filePath}" alt="Couldn't show image"></li>`
    }
    imageHtml += `</ul>`


    let soundHtml = `<ul>`
    for(let i = 0; i < data.sounds.length; i++){
        soundHtml +=
            `<li>
                <audio controls>
                    <source src="../../../static/${data.sounds[i].filePath}" type="audio/wav">
                </audio>
            </li>`
    }
    soundHtml += `</ul>`

    document.getElementById("Images").innerHTML = imageHtml
    document.getElementById("Sounds").innerHTML = soundHtml

    console.log(data)
}