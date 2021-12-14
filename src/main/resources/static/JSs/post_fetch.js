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
                <section className="postImageFlex">
                    <ul th:each="image : ${data.images}">
                        <li><img th:src="@{image.getFilePath()}" alt="Couldn't show image..."></li>
                    </ul>
                </section>`;

            console.log(data)
        })
}