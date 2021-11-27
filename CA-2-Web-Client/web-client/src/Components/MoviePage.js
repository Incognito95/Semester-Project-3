import { useState, useEffect } from "react";


const MoviePage = () => {
    const [moviesList, setJokesList] = useState([]);
    useEffect(() => {
        const timer = setInterval( () => {
            fetch("http://localhost:8080/devops_starter_war_exploded/api/info/moviepage")
                .then(res => res.json())
                .then(data => {
                    setJokesList(data);
                    console.log(moviesList);
                });
        }, 3000);
        return () => clearInterval(timer);
    });

    return (
        <div className="">
            {moviesList.map(movies => {
                return (
                    <div className="container">
                        <div className="row">
                            <div className="col-sm">
                                <div className="mt-4">
                                    <div className="">
                                        <img src="..." className="card-img-top" alt="..." />
                                        <div className="card-body">
                                            <h5 className="card-title">{movies.title}</h5>
                                            <p className="card-text">{movies.description}</p>
                                            <img src={movies.image} />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                )
            })}
        </div>
    )
}

export default MoviePage;