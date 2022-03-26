

export const fetchRandom = () => (dispatch) => {

    dispatch({ type: "view-loading" });

    return fetch(`http://localhost:8080/dicesRoller`, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({}) // body data type must match "Content-Type" header
    }).then(response => response.json())
      .then(json => {
          console.log(json)
          dispatch({ type: "random-result", data: json });
          dispatch({ type: "view-loaded" });
        })
}


//TODO: agregar las demas acciones