import { useState, useEffect } from "react";


const JokeAPI = () => {
    const [jokesList, setJokesList] = useState([]);
    useEffect(() => {
        const timer = setInterval( () => {
            fetch("https://v2.jokeapi.dev/joke/Any")
                .then(res => res.json())
                .then(data => {
                    setJokesList(data);
                    console.log(jokesList);
                });
        }, 3000);
        return () => clearInterval(timer);
    });

    return (
        <div>

            <div className="result-box form-control w-50 mt-3" aria-readonly>
                <p>Setup: {jokesList.setup}</p>
                <p>Delivery: {jokesList.delivery}</p>
            </div>

        </div>
    )
}

export default JokeAPI;