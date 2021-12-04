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
                                        <div className="card border-0">
                                            <h5 className="card-title">{movies.title}</h5>
                                            <Link to={`/moviepage/${movies.id}`}>
                                             <img src={`/images/${movies.images}`} className="card-img-top" alt="..." />
                                                <div className="card-body">
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