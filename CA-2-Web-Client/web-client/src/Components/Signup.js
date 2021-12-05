import React, {useState} from "react";

function Signup() {

    return (

        <div className="form-signin">
            <h1 className="h3 mb-3 fw-normal text-center" id="form">Please signup</h1>
            <form onChange="">
                <div className="Form-fields">
                    <input type="text" id="username" className="ControlInput ControlInput--email" placeholder="Username" required />
                    <label htmlFor="username" className="Control-label Control-label--email"></label>
                    <div className="Control-requirements Control-requirements--email">
                        The username you input is incorrect!
                    </div>


                    <input type="checkbox" id="show-password" className="show-password" required/>

                    <label htmlFor="show-password" className="Control-label Control-label--showPassword"></label>

                    <input type="password" id="password" name="password" placeholder="Password" autoComplete="off" autoCapitalize="off" className="ControlInput ControlInput--password" required />

                    <label htmlFor="password" className="Control-label Control-label--password">Password</label>

                    <div className="Control-requirements">
                        The password you input is incorrect!
                    </div>

                    <button onClick="" className="w-100 btn btn-lg btn-primary mt-2" id="button" type="submit">Login</button>

                </div>
            </form>
        </div>

    )

}

export default Signup;