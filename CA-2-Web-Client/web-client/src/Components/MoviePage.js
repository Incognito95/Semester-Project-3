import { useState, useEffect } from "react";
import facade from "../ApiFacade";
import { useParams } from "react-router-dom";


const MoviePage = ({userName}) => {

    const [movies, setmovies] = useState([]);
    const [comment, setComment] = useState({});
    const [comments, setComments] = useState([]);

    let { id } = useParams();
    console.log("id:", id);

    // show movie
    useEffect(() => {
        facade.fetchData("moviepage/" + id)
            .then(data => {
                setmovies(data);
        })
    },[])

    // add comment
    const addComment = (event) => {
        event.preventDefault(); // prevent page from reloading after submitting form
        const body = {"username": userName, "movieId": id, ...comment};
        console.log("body", body);
        facade.postData(body, "AddMovieComment").then(() => {
            facade.fetchData("DisplayMovieComments/" + id)
                .then(data => {
                    setComments(data);
                })
        })
    }

    // show comments
    useEffect(() => {
        facade.fetchData("DisplayMovieComments/" + id)
            .then(data => {
                setComments(data);
            })
    }, [comment]);

    const changeComment = (event) => {
        event.preventDefault();
        setComment({ ...comment,[event.target.id]: event.target.value });
    }



    return (
    <div className="container mt-5 mb-5">
                    <div className="row d-flex justify-content-center">
                        <div className="col-md-10">
                            <div className="">
                                <div className="row">
                                    <div className="col-md-6">
                                        <div className="images p-3">
                                            <div className="text-center p-4">
                                                <img src={`/images/${movies.images}`} width="" value=""/></div>
                                            <div className="thumbnail text-center">
                                                <img src="" width="70"/>
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
                                            <div className="mt-4 mb-3">
                                                <h5 className="text-uppercase">{movies.title}</h5>
                                            </div>
                                            <p className="about">{movies.description}</p>


                                            <form className="rating">
                                                <label>
                                                    <input type="radio" name="stars" value="1"/>
                                                    <span className="icon">★</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="stars" value="2"/>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="stars" value="3"/>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="stars" value="4"/>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="stars" value="5"/>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                    <span className="icon">★</span>
                                                </label>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div className="comments">
                            <form onChange={changeComment}>
                                <h3>Post a comment</h3>
                                <textarea name="comment" className="form-control mt-3" id="comment" cols="30" rows="10" name="comment"></textarea>
                                <button onClick={addComment} type="submit" className="btn btn-success mt-3 float-end">Send</button>
                            </form>
                        </div>

                        comment: {JSON.stringify(comment)}

                        <div className="show-comments">
                            <h3>Comments</h3>
                            <div className="p-5 mb-4 bg-light mt-3">
                                    <div className="container-fluid py-5">
                                        <ul>
                                            {comments.map(comment => <li key={comment.id}> {comment.comment}</li>)}
                                        </ul>
                                    </div>
                            </div>
                        </div>

                    </div>
        </div>

    )
}

export default MoviePage;