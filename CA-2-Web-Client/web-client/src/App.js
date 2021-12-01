import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useParams,
    useRouteMatch,
    NavLink
} from "react-router-dom";

import Login from "./Components/Login";
import Menu from "./Components/Menu";
import Home from "./Components/Home";
import NoMatch from "./Components/NoMatch";
import AllMovies from "./Components/AllMovies";
import MoviePage from "./Components/MoviePage";
import React, { useState,useEffect } from "react";
import facade from "./ApiFacade";
import SearchBar from "./Components/Searchbar";






function App() {

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
        <div className="App">
            <SearchBar placeholder="Enter a Book Name..." data={moviesList} />
        </div>
    );

    const [loggedIn, setLoggedIn] = useState(false)

    const logout = () => {
        // confused on how we get this to work as it's not being called
        facade.logout()
        setLoggedIn(false)
    }

    if (logout == true) {
        return "admin has logged out"
    }

    const login = (user, pass) => {
        facade.login(user,pass)
            .then(res =>setLoggedIn(true));
    }

    if (login === true) {
        return "admin has logged in"
    }

    return (
        <div>
            {!loggedIn ? (<Login login={login} />) :
                (<div>
                    <Menu />
                    <Switch>
                         <Route exact path="/">
                         <Home />
                         </Route>
                            <Route exact path="/allmovies">
                                <AllMovies />
                            </Route>
                        <Route path="/login">
                                <Login/>
                        </Route>
                        <Route exact path="/moviepage">
                             <MoviePage />
                        </Route>
                        <Route exact path="/moviepage/:id">
                            <MoviePage />
                        </Route>
                        <NoMatch />
                    </Switch>
                    <LoggedIn />
                </div>)}

        </div>
    )

}


function LoggedIn() {
    const [dataFromServer, setDataFromServer] = useState("Loading...")

    useEffect(() => {
        facade.fetchData().then(data=> setDataFromServer(data.msg));
    }, [])

    return (
        <div>

        </div>
    )

}



export default App;
