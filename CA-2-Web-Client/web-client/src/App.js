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
import Searchbar from "./Components/Searchbar";

import React, { useState,useEffect } from "react";
import facade from "./ApiFacade";
import {render} from "react-dom";



function App() {
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

    render()
    {
        return (
            <div>
                {!loggedIn ? (<Login login={login}/>) :
                    (<div>
                        <Menu/>
                        <Switch>
                            <Route exact path="/">
                                <Home/>
                            </Route>
                            <Route exact path="/allmovies">
                                <AllMovies/>
                            </Route>
                            <Route path="/login">
                                <Login/>
                            </Route>
                            <Route exact path="/moviepage">
                                <MoviePage/>
                            </Route>
                            <Route exact path="/moviepage/:id">
                                <MoviePage/>
                            </Route>
                            <NoMatch/>
                        </Switch>
                        <LoggedIn/>
                    </div>)}
                <Searchbar placeholder={"Enter search "} handleChange={(e) => console.log(e.target.value())}/>

            </div>
        )
    }
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
