import {NavLink} from 'react-router-dom';
import React, {useState} from "react";
import facade from "../ApiFacade";

class Menu extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            opened: false
        };
    }

    render() {


    const logout = () => { facade.logout() }

    return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
            <NavLink exact active className="navbar-brand" to="/">Navbar</NavLink>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="/">Welcome</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="chuck">Chuck Norris Jokes</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="dad">Dad Jokes</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="jokeapi">Joke API</NavLink>
                    </li>
                </ul>
                <form className="d-flex">
                    <NavLink exact active className="active nav-link text-black" to="#" id="user">
                        {(() => {
                            const admin = "Admin";
                            const user = "User";

                            if (admin == admin) {
                                return "You are now logged in as: " + admin;
                            } else if (admin != admin) {
                                return "You are now logged in as: " + user;
                            }
                        })()}
                    </NavLink>
                    <button onClick={logout} className="btn btn-success btn-logout">Logout</button>
                </form>
            </div>
        </div>
    </nav>
        )
    }
}


export default Menu;