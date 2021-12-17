function headAndHeaderTitles() {
    const response = await fetch("http://localhost:8080/tours")
    const data = await response.json()
}