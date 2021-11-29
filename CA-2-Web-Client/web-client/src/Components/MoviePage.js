import {useState, useEffect} from "react";


const MoviePage = () => {
    // show movie
    const [moviesList, setMovieList] = useState([]);
    useEffect(() => {
        const timer = setInterval(() => {
            fetch("http://localhost:8080/devops_starter_war_exploded/api/info/moviepage")
                .then(res => res.json())
                .then(data => {
                    setMovieList(data);
                    console.log(moviesList);
                });
        }, 3000);
        return () => clearInterval(timer);
    });

    // show comments
    const [comments, setComments] = useState([]);
    useEffect(() => {
        const timer = setInterval(() => {
            fetch("http://localhost:8080/devops_starter_war_exploded/api/info/DisplayMovieComments")
                .then(res => res.json())
                .then(data => {
                    setComments(data);
                    console.log(moviesList);
                });
        }, 3000);
        return () => clearInterval(timer);
    });


    return (
    <div className="container mt-5 mb-5">
            {moviesList.map(movies => {
                return (
                    <div className="row d-flex justify-content-center">
                        <div className="col-md-10">
                            <div className="">
                                <div className="row">
                                    <div className="col-md-6">
                                        <div className="images p-3">
                                            <div className="text-center p-4"><img id="main-image"
                                                                                  src="https://dummyimage.com/300x500/f8f9fa/000000"
                                                                                  width="" value=""/></div>
                                            <div className="thumbnail text-center">
                                                <img src=""
                                                     width="70"/> <img
                                                onClick="change_image(this)" src=""
                                                width="70"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="product p-4">
                                            <div className="d-flex justify-content-between align-items-center">
                                                <div className="d-flex align-items-center"><i
                                                    className="fa fa-long-arrow-left"></i> <span
                                                    className="ml-1"></span>
                                                </div>
                                                <i className="fa fa-shopping-cart text-muted"></i>
                                            </div>
                                            <div className="mt-4 mb-3"><span
                                                className="text-uppercase text-muted brand">Orianz</span>
                                                <h5 className="text-uppercase">{movies.title}</h5>
                                                <div className="price d-flex flex-row align-items-center"><span
                                                    className="act-price">$20</span>
                                                    <div className="ml-2"><small className="dis-price">$59</small>
                                                        <span>40% OFF</span></div>
                                                </div>
                                            </div>
                                            <p className="about">{movies.description}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div className="comments">
                            <form onChange="">
                                <h3>Post a comment</h3>
                                <textarea name="comment" className="form-control mt-3" id="" cols="30" rows="10" name="comment"></textarea>
                                <button onClick="" type="submit" className="btn btn-success mt-3 float-end">Send</button>
                            </form>
                        </div>

                        <div className="show-comments">
                            <h3>Comments</h3>
                            {comments.map(comment => {
                                return (
                            <div className="p-5 mb-4 bg-light mt-3">
                                    <div className="container-fluid py-5">
                                        <p>{comment.username}</p>
                                        <p>{comment.comment}</p>
                                    </div>
                            </div>
                                )
                            })}
                        </div>

                    </div>
                )
            })}
        </div>

    )
}

export default MoviePage;