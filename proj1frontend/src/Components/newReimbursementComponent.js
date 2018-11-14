import React from 'react';

export class newReimbursementComponent extends React.Component {
  //for login functionality: If a user arrives at this component 
  // and has not yet logged in, they should be sent to sign-in component

  constructor(props) {
    super(props);
    this.state = {
      amount: 0,
      description: '',
      receipt: '',
      type: 1
    }
  };

submit = (event) => {
  fetch('http://localhost:8080/project1/reimbursements/' ,
  {
    headers: { "Content-Type":"application/x-www-form-urlencoded" },
    method: "post",
    body: JSON.stringify({
      "reimb_amount": this.state.amount,
      "reimb_description": this.state.description,
      "reimb_receipt": this.state.receipt,
      "reimb_type_id": this.state.type,
      "reimb_author": 1, //THIS IS A TEMPORARY HARD-CODE, WILL BE REPLACED WHEN LOGIN FUNCITONALITY IS IN PLACE
      "reimb_resolver": null,
      "reimb_status_id": 0
    })
  })
  console.log(this.state)

}


 update = (event) => {

    if(event.target.id ==='amountInput')
    {
      console.log("This is the amount")
      this.setState({
        ...this.state,
        amount: event.target.value
      })
    }
    if(event.target.id === 'descInput')
    {
      this.setState({
        ...this.state,
        description: event.target.value
      })
    }
    if(event.target.id === 'receiptInput')
    {
      this.setState({
        ...this.state,
        receipt: event.target.value
      })
    }
    console.log(this.state)

   }

  render() {
    return (
      <div>
        <form>
          Reimbursement Amount: <br></br>
          <input id="amountInput" type="number" onChange={this.update}></input> <br></br>
          Reimbursement Description: <br></br>
          <input id="descInput" type="text" onChange={this.update}></input> <br></br>
          Reimbursement Receipt: <br></br>
          <input id="receiptInput" type="text" onChange={this.update}></input> <br></br>
          Reimbursement Type: <br></br>
          <select className="form-control" id="typeInput" onChange={this.update}>
            <option value="1">Lodging</option>
            <option value="2">Travel</option>
            <option value="3">Food</option>
            <option value="4">Other</option>
          </select>
          <button className="btn btn-primary" onClick = {this.submit}>Submit</button>
        </form>
      </div>
    )
  }
}