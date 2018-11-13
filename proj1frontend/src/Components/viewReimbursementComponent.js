import React from 'react';

export class viewReimbursementComponent extends React.Component {
        //for login functionality: If a user arrives at this component 
    // and has not yet logged in, they should be sent to sign-in component

    /*Page Structure:
    This page should display a table of all reimbursements by default.
    When prompted (probably with a button) the table should display all reimbursements by a given user
    When prompted (probably with a button) the table should display all reimbursements ordered by status
    When prompted (probably with a button) the table should display a reimbursement with the given id */
  render() {
    return (
      <div>
        View Reimbursements!
      </div>
    )
  }
}