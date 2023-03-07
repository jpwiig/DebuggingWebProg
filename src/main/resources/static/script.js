$(() => {
    console.log("ready");
         loadMovies();

})

function loadMovies(){
    $.post("/movies",(data) => {
        //adds movie to select
        console.log("movies" + data);
        let out = "<select id = 'movies' >";
        for (const movie of data) {
            out += "<option value='" + movie.title + "'>" + movie.title + "</option>";
        }
        out += "</select>";
        $("#movies").html(out);

    })
}

function searchdir() {
    let director = document.getElementById("director").value;
    const url = "/aDirector?director="
    $.get(url + director, (data) => {
        let directors = "<table><tr><th>Title</th><th>Director</th><th>Year</th></tr>";
        for (let movie of data) {
            directors += "<tr><td>" + movie.title + "</td><td>" + movie.director + "</td><td>" + movie.year + "</td></tr>";
        }
        directors += "</table>";
        document.getElementById("result").html(directors);
    })
}