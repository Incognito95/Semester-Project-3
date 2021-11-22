import { useState, useEffect } from "react";

const Dad = () => {
    const [jokesList, setJokesList] = useState([]);
    useEffect(() => {
        const timer = setInterval( () => {
            fetch("https://icanhazdadjoke.com/", {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                }
            })
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
                <p className="mt-3">id: {jokesList.id}</p>
                <p className="mt-3">joke: {jokesList.joke}</p>
                <p className="mt-3">status: {jokesList.status}</p>
            </div>

        </div>
    )
}

export default Dad;