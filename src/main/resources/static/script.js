$(() => {
    console.log("ready");
    loadMovies();
    $("#movie").on("input", () => {

        let movie = $("#movie").val();
        let out = "<table><tr><th>Title</th><th>Director</th><th>Year</th><th>genre</th></tr>";
        $.get("/searchformovie?movie=" + movie, (data) => {
            out += "<tr><td>" + data.title + "</td><td>" + data.director + "</td><td>" + data.year + "</td><td>" + data.genre + "</td></tr>";

        })
        out += "</table>";
        $("#results").html(out);
    })
printallsorted()
})

function printallsorted(){
    //TODO: hella broken (prints values @every refresh)
    $("#results").html("");
$.get("/sortbyGenre", (data) => {
        let out = "<table><tr><th>Title</th><th>Director</th><th>Year</th></tr>";
        for (let movie of data) {
            out += "<tr><td>" + movie.title + "</td><td>" + movie.director + "</td><td>" + movie.year + "</td><td>" + movie.genre +"</td></tr>";
        }
        out += "</table>";
        $("#results").html(out);
    })

}

function loadMovies() {
    $.post("/addMovies", (data) => { //same get as in the Controller
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
    let director = $("#director").val();
    console.log(director)
    const url = "/aDirector?director="
    $.get(url + director, (data) => {
        let directors = "<table><tr><th>Title</th><th>Director</th><th>Year</th></tr>";
        for (let movie of data) {
            directors += "<tr><td>" + movie.title + "</td><td>" + movie.director + "</td><td>" + movie.year + "</td></tr>";
        }
        directors += "</table>";
        $("#results").html(directors);
    })


}

