function Home() {

    return (
        <div className="mt-5">
            <h3 className="welcome-header">Velkommen til vores hjemmeside, her kan du få nogen:</h3>
            <ul className="list">
                <li>Chuck Norris jokes</li>
                <li>Dad jokes</li>
                <li>Joke API</li>
                <li>Login system med authentication</li>
            </ul>


            <h3 className="mt-5 instructions-header">Instructions on how to use the Quick Start Project.</h3>
            <div className="col-md-6">
                <div className="p-4 bg-light instructions-box">
                    <li className="instructions-list">Open the project in your preferred code editor</li>
                    <li className="instructions-list">Go into the terminal and input the following commands <br />(if the packages didn't come included when you downloaded the project then input the following command: <br /><code>npm install</code> then to start the project type: <code> npm start</code></li>
                    <li>Once you have typed <code>npm start</code> then the project should open in the browser</li>
                </div>
            </div>
        </div>
    )
}

export default Home;