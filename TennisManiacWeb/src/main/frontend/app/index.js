import React from 'react';
import ReactDOM from 'react-dom';
import Home from './features/home/Home.jsx'

let load = () => {
    ReactDOM.render(
        <Home/>,
        document.getElementById('container')
    );
}

load();