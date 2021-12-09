const URL = "http://localhost:8080/devops_starter_war_exploded";

function handleHttpErrors(res) {
    if (!res.ok) {
        return Promise.reject({ status: res.status, fullError: res.json() })
    }
    return res.json();
}

function ApiFacade() {
    /* Insert utility-methods from a later step (d) here (REMEMBER to uncomment in the returned object when you do)*/
    const setToken = (token) => {
        localStorage.setItem('jwtToken', token)
    }
    const getToken = () => {
        return localStorage.getItem('jwtToken')
    }
    const loggedIn = () => {
        const loggedIn = getToken() != null;
        return loggedIn;
    }

    const logout = () => {
        localStorage.removeItem("jwtToken");
    }

    const login = (user, password) => {
        const options = makeOptions("POST", true,{username: user, password: password });
        return fetch(URL + "/api/login", options)
            .then(handleHttpErrors)
            .then(res => {setToken(res.token) })
    }

    const fetchData = (endpoint) => {
        const options = makeOptions("GET",true); //True add's the token
        return fetch(URL + "/api/info/" + endpoint, options).then(handleHttpErrors);
    }

    const postData = (body, endpoint) => {
        const options = makeOptions("POST",true, body); //True add's the token
        console.log(body);
        return fetch(URL + "/api/info/" + endpoint, options).then(handleHttpErrors);
    }

    const makeOptions = (method,addToken,body) => {
        var opts = {
            method: method,
            headers: {
                "Content-type": "application/json",
                'Accept': 'application/json',
            }
        }
        if (addToken && loggedIn()) {
            opts.headers["x-access-token"] = getToken();
        }
        if (body) {
            opts.body = JSON.stringify(body);
        }
        return opts;
    }
    return {
        makeOptions,
        setToken,
        getToken,
        loggedIn,
        login,
        logout,
        fetchData,
        postData
    }
}


const facade = ApiFacade();
export default facade;
