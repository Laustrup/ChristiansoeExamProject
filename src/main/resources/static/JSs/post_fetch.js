getPost()
function getPost() {
    let id = sessionStorage.getItem("locationId")

    fetch("http://localhost:8080/location?id=" + id)
        .then((response) => {
            return response.json()
        })
        .then((data) => {
            document.getElementById("Title").innerText = data.title
            document.getElementById("Report").innerText = data.report
            document.getElementById("Images").innerHTML = `    
                <section class="postImageFlex">
                    <ul th:each="image : ${data.images}">
                        <li><img th:src="@{image.getFilePath()}" alt="Couldn't show image..."></li>
                    </ul>
                </section>`;


            document.getElementById("Sounds").innerHTML = `
            <section class="postSoundFlex">
                <ul th:each="sound : ${data.sounds}">
                    <li>
                        <audio controls>
                            <source th:src="@{image.getFilePath()}" type="audio/wav" >
                        </audio>
                    </li>
                </ul>
            </section>`;



            console.log(data)
        })
}