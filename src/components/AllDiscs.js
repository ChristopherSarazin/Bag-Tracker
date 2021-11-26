import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Link } from "react-router-dom";


const AllDiscs = () => {

    const [allDiscs, setAllDiscs] = useState([]);

    const [deleterClicked, setDeleterClicked] = useState(false)


    useEffect(() => {
        axios.get("http://localhost:8080/getDiscs")
        .then(res => {
            console.log("res is this --->", res)
            setAllDiscs(res.data)
        })
        .catch(err => console.log("Error--->", err))
    }, [deleterClicked]);



    const deleter = (e, discId) => {
        axios.delete(`http://localhost:8080/oneDisc/${discId}/deleteDisc`)
            .then(res => {
                console.log("what was deleted--->", discId)
                setDeleterClicked(!deleterClicked)
            })
            .catch(err => console.log("error", err))
    }


    return(
        <div>
            <h3>What you like to throw</h3>
            <Link to={'/allBags'} className = "btn btn-info">what holds what you throw</Link>
            <br />
            <br />
            <Link to={'/'} className='btn btn-info'>Home</Link>
            <br />
            
            {allDiscs.map((allDiscs, idx) => {
                if (allDiscs.discCompany === "Innova")
                    return(<div className="container">
                    <table className="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Company</th>
                            <th scope="col">Name</th>
                            <th scope="col">Type</th>
                            <th scope="col">Speed</th>
                            <th scope="col">Glide</th>
                            <th scope="col">Turn</th>
                            <th scope="col">Fade</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                        <tbody>
                            <tr>
                                <td>{allDiscs.discCompany}</td>
                                <td>{allDiscs.discName}</td>
                                <td>{allDiscs.type}</td>
                                <td>{allDiscs.speed}</td>
                                <td>{allDiscs.glide}</td>
                                <td>{allDiscs.turn}</td>
                                <td>{allDiscs.fade}</td>
                                <td><button onClick={(e) => deleter(e, allDiscs.id)} className="btn btn-success">delete</button></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>)
            })}
            
        </div>
    );

};

export default AllDiscs;