import { useState, useEffect } from "react";
// import { path } from "../Images/";

const AllMovies = () => {
    const [movieList, setMovieList] = useState([]);
    useEffect(() => {
        const timer = setInterval( () => {
            fetch("http://localhost:8080/devops_starter_war_exploded/api/info/movies")
                .then(res => res.json())
                .then(data => {
                    setMovieList(data)
                });
        }, 3000);
        return () => clearInterval(timer);
    });


    return (
            <div className="">
                 {movieList.map(movies => {
                     return (
                         <div className="container">
                             <div className="row">
                                 <div className="col-sm">
                                     <div className="mt-4 card-group">
                                        <div className="card">
                                             {/*<img src={path + movies.images} className="card-img-top" alt="..." />*/}
                                            <a href="/moviepage/">
                                            <div className="card-body">
                                                    <h5 className="card-title">{movies.title}</h5>
                                                    {/*<p className="card-text">{movies.description}</p>*/}
                                                </div>
                                            </a>
                                            </div>
                                     </div>
                                 </div>
                                 <div className="col-sm">
                                     <div className="mt-4 card-group">
                                         <div className="card">
                                             <img src="..." className="card-img-top" alt="..." />
                                             <div className="card-body">
                                                 <h5 className="card-title">{movies.title}</h5>
                                                 {/*<p className="card-text">{movies.description}</p>*/}
                                             </div>
                                         </div>
                                     </div>
                                 </div>
                                 <div className="col-sm">
                                     <div className="mt-4 card-group">
                                         <div className="card">
                                             <img src="{movies.movie_images}" className="card-img-top" alt="..." />
                                             <div className="card-body">
                                                 <h5 className="card-title">{movies.title}</h5>
                                                 {/*<p className="card-text">{movies.description}</p>*/}
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

export default AllMovies;