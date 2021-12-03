import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const AllMovies = () => {
    const [moviesList, setMovieList] = useState([]);
    useEffect(() => {
        const timer = setInterval( () => {
            fetch("http://localhost:8080/devops_starter_war_exploded/api/info/movies")
                .then(res => res.json())
                .then(data => {
                    setMovieList(data);
                });
        }, 3000);
        return () => clearInterval(timer);
    });


    return (
            <div className="">
                 {moviesList.map(movies => {
                     return (
                         <div className="container movies">
                             <div className="row">
                                     <div className="mt-4 card-group">
                                        <div className="card">
                                             {/*<img src={path + movies.images} className="card-img-top" alt="..." />*/}
                                            <Link to={`/moviepage/${movies.id}`}>
                                                <div className="card-body">
                                                        <h5 className="card-title">{movies.title}</h5>
                                                        {/*<p className="card-text">{movies.description}</p>*/}
                                                </div>
                                            </Link>
                                            </div>
                                     </div>
                             </div>
                         </div>
                     )
                 })}
            </div>
    )
}

export default AllMovies;