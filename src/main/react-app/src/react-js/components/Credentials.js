import React from "react";
import Reload from "./Filters/Reload";
import Size from "./Filters/Size";
import Autorefresh from "./Filters/Autorefresh";
import Error from "./Alert/Error";


export default class Credentials extends React.Component {
  constructor(props) {
	    super(props);
	    this.state = {
	      user: null,
	      password: null,
	      error: null,
	    };
  }
  
  handlePasswordChange(e) {
  	const password = e.target.value;
  	const _state = this.state;
  	_state.password = password;
  	this.setState(_state);
  	if(this.validate()) {
  	  	this.props.onChange(_state.user, _state.password);	
  	}
  }
  
  handleUserChange (e) {
  	const user = e.target.value;
  	const _state = this.state;
  	_state.user = user;
  	this.setState(_state);
  	if(this.validate()) {
  	  	this.props.onChange(_state.user, _state.password);	
  	} else {
  	  	this.props.onChange(null, null);	
  	}
  }
  
  validate () {
  	const _state = this.state;
  	var msg = "";
  	var isValid = true;
  	if ((_state.user == null || _state.user.trim() == "")
  		|| (_state.password == null || _state.password.trim() == ""))
  	{
  		// comment error message because is duplicated.
  		_state.error = "User and Password can't be empty";
  		isValid = false;
  		
  	} else {
  		_state.error = null;
  	}
  	this.setState(_state);
  	return isValid;
  }
  
  render() {
    return (
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-target="#filter-body-credentials">
                    <i class="fa fa-user fa-fw"></i>Credentials 
                </div>
                <div class="panel-body collapse in" id="filter-body">
                    <div class="row">
                      <div class="form-group col-lg-6">
                        <label>User:</label>
                        <input class="form-control" onChange={this.handleUserChange.bind(this)} />
                      </div>
                      <div class="form-group col-lg-6">
                        <label>Password:</label>
                        <input type="password" class="form-control" onChange={this.handlePasswordChange.bind(this)} />
                      </div>
                    </div>
                </div>                
                <Error text={this.state.error} />
            </div>

        </div>

    );
  }
}