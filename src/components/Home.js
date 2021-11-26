import React, {  } from "react";

import { Link } from "react-router-dom";


const HomePage = ()=>{
    return(
        <>
            <Link to={'/allDiscs'} className="btn btn-info">All Discs</Link>
            <br  />
            <Link to={'/allBags'} className="btn btn-info">All Bags</Link>
        </>
    )
}

export default HomePage;