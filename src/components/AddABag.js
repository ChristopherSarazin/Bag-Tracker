import React, { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router"



const AddABag = () => {

    const history  = useHistory();

    let [formInfo, setFormInfo] = useState({
        bagname: " ",
        courseCondition:" ",
        courseType:" "
    })

    const changeHandler = (e)=>{
        console.log(e.target.name, e.target.value)
        setFormInfo({
            ...formInfo,
            [e.target.name]:e.target.value
        })
    }

    const submitHandler = (e) => {
        e.preventDefault();
        console.log("Form subbmitted with this info ==>", formInfo)
        axios.post("http://localhost:8080/createBag",formInfo)
            .then(res=>{
                console.log("res after submission ==>", res)
                history.push("/allBags")
            })
            .catch(err => console.log("error ==>", err))
    }

    return (
        <div>
            <h1>Create A New Bag!</h1>
        <form onSubmit={submitHandler}>
            <div>
                <label htmlFor="">Bag Name:</label>
                <input onChange={changeHandler} type="text" name="bagname" id="" className="form-control" />
            </div>
            <div>
                <label htmlFor="">Weather Condition:</label>
                <input onChange={changeHandler} type="text" name="courseCondition" id="" className="form-control" />
            </div>
            <div>
                <label htmlFor="">Course Type:</label>
                <input onChange={changeHandler} type="text" name="courseType" id="" className="form-control" />
            </div>
            <input className= "btn btn-primary" type="submit" value="Create Bag" />
        </form>
        </div>
    )



}

export default AddABag;