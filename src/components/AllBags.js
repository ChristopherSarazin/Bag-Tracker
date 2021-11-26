import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Link } from "react-router-dom";


const AllBags = () => {

    const [allBags, setAllBags] = useState([]);

    const [deleterClicked, setDeleterClicked] = useState(false)


    useEffect(() =>{
        axios.get("http://localhost:8080/getBags")
        .then(res => {
            console.log("res is this ==>", res)
            setAllBags(res.data)
        })
        .catch(err => console.log("Error==>", err))
    }, [deleterClicked]);


    const deleter = (e,bagId) => {
        axios.delete(`http://localhost:8080/getBags/${bagId}/deleteBag`)
        .then(res => {
            console.log("what was deleted ==>", bagId)
            setDeleterClicked(!deleterClicked)
        })
        .catch(err => console.log("Error", err))
    }



    return(
        <div>
            <h1>Your collection of Bags</h1>
            <br />
            <Link to={'/AddABag'} className="btn btn-info">Create a Bag</Link>
            <br />
            <Link to={'/'} className='btn btn-info'>Home</Link>
            <br />
            <Link to={'/allDiscs'} className='btn btn-info'>Discs</Link>
            <br />
            {allBags.map((allBags, idx) => {
                return (
                    <div className="container">
                        <table  className="table table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Bag Name</th>
                                    <th scope="col">Weather Conditions</th>
                                    <th scope="col">Course Type</th>
                                    <th scope="col" >Actions</th>
                                </tr>
                            </thead>
                                <tbody>
                                    <tr>
                                        <td><Link to={`/oneBag/${allBags.id}`}>{allBags.bagname}</Link></td>
                                        <td>{allBags.courseCondition}</td>
                                        <td>{allBags.courseType}</td>
                                        <td><button  onClick={(e) => deleter(e, allBags.id)}  >Remove Bag</button></td>
                                    </tr>
                                </tbody>
                        </table>
                    </div>
                )
            })}
        </div>
    )
}

export default AllBags;