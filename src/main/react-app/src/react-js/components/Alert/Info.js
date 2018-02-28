import React from "react";

export default class Info extends React.Component {
	
	render() {
		if (this.props.text == null || this.props.text.trim() == "") {
      return (<div></div>);
		}
		return (
			    <div class="alert alert-info fade in alert-dismissible">
              <strong>{this.props.text}</strong>
          </div>
    )
	}
	
}