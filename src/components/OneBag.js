import React, { useEffect, useState } from 'react';
import { useParams } from "react-router";
import axios from 'axios';
import { Link } from "react-router-dom";


const OneBag = () => {

    const { id } = useParams();


    const [bagInfo, setBagInfo] = useState([])

    const [discsInBag, setDiscsInBag] = useState([])


    useEffect(() => {
        axios.get(`http://localhost:8080/getBags/${id}`)
        .then(res => {
            console.log("res", res)
            setBagInfo(res.data)
            setDiscsInBag(res.data.discsInBag)
        })

        .catch(err => console.log(err))
    },[])

    const removeDisc = (e,bagId,discId) => {
        axios.put(`http://localhost:8080/getBags/${bagId}/removeDisc/${discId}`)
        .then(res => {
            console.log("this was removed", res)
            setBagInfo(res.data)
            setDiscsInBag(res.data.discsInBag)
        })
        .catch(err => console.log(err))
    }




    return (
        <div>
            <Link to={`/oneBag/${id}/discs`} >Add Discs To Bag</Link>
            <h1>{bagInfo.bagname}</h1>
            <h3>{bagInfo.courseType}</h3>
            <h3>{bagInfo.courseCondition}</h3>
            {discsInBag.map((discsInBag, idx) => {
                return (
                    <div>
                <h5>{discsInBag.discName}------<button onClick={(e) => removeDisc(e,bagInfo.id,discsInBag.id)}>Remove</button></h5>
                </div>
                )
            })}
        </div>
    )

}

export default OneBag;