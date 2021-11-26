import React, { useState, useEffect } from "react";
import axios from 'axios';

import { useParams } from "react-router";


const AddDiscsToBag = () => {

    const { id } = useParams();

    const [allDiscs, setAllDiscs] = useState([]);

    const [added, setAdded] = useState(false);


    useEffect(() => {
        axios.get(`http://localhost:8080/getBags/${id}/discs`)
        .then(res => {
            console.log("res is this ===>", res)
            setAllDiscs(res.data)
        })
        .catch(err => console.log("error ===>", err))
    },[added]);


    const addToBag = (e, bagId, discId) => {
        axios.put(`http://localhost:8080/getBags/${bagId}/discs/${discId}`)
            .then(res => {
                console.log("what was added", discId)
                setAdded(!added)
            })
            .catch(err => console.log("error", err))
    }

    return(
        <div>
            {allDiscs.map((allDiscs, idx) => {
                return (<div className="container">
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
                            <td><button onClick={(e) => addToBag(e, id , allDiscs.id)} >Add</button></td>
                        </tr>
                    </tbody>
                    </table>
                </div>)
            })}
        </div>
    )

}

export default AddDiscsToBag;