import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import facade from "../ApiFacade";

const AllMovies = () => {
    const [moviesList, setMovieList] = useState([]);
    useEffect(() => {
        facade.fetchData("movies")
            .then(data => {
                setMovieList(data);
            })
    }, []);


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