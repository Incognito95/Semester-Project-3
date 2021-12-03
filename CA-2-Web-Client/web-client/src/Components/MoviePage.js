import { useState, useEffect } from "react";
import facade from "../ApiFacade";
import { useParams } from "react-router-dom";


const MoviePage = () => {

    const [movies, setmovies] = useState([]);
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

    // show comments
    useEffect(() => {
        facade.fetchData("DisplayMovieComments")
            .then(data => {
                setComments(data);
            })
    }, []);

    const addComment = (evt) => {

    }

    const updateComment = (evt) => {

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
                                                <img id="main-image" src="https://dummyimage.com/300x500/f8f9fa/000000" width="" value=""/></div>
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
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div className="comments">
                            <form onChange={updateComment}>
                                <h3>Post a comment</h3>
                                <textarea name="comment" className="form-control mt-3" id="" cols="30" rows="10" name="comment"></textarea>
                                <button onClick={addComment} type="submit" className="btn btn-success mt-3 float-end">Send</button>
                            </form>
                        </div>

                        <div className="show-comments">
                            <h3>Comments</h3>
                            <div className="p-5 mb-4 bg-light mt-3">
                                    <div className="container-fluid py-5">
                                        <p>{comments.username}</p>
                                        <p>{comments.comment}</p>
                                    </div>
                            </div>
                        </div>

                    </div>
        </div>

    )
}

export default MoviePage;