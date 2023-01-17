import { createContext, useState, useEffect, useReducer } from "react";
import axios from "axios";




export const initialState = {
  currentState: "Light", 
  nextState: "Dark"
}

export const ContextGlobal = createContext();

const themeFunction = (state, { type }) => {
  switch (type) {
    case "Dark":
      return {
        currentState: "Dark",
        nextState: "Light",
      }
    case "Light":
      return {
        currentState: "Light",
        nextState: "Dark",
      }
    default:
      return state;
  }
}

export const ContextProvider = ({ children }) => {
  const [data, setData] = useState([]);
  const [state, dispatch] = useReducer(themeFunction, initialState);

  const contextValues = {
    state,
    dispatch,
    data
  }

  const getData = () => {
    console.log("Making API call ...");
    axios.get('https://jsonplaceholder.typicode.com/users')
      .then(res => { setData(res.data); })
      .catch(err => console.log(err))
  }

  useEffect(() => {
    getData();
  }, []);

  return (
    <ContextGlobal.Provider value={ contextValues }>
      { children }
    </ContextGlobal.Provider>
  );
};
