import React from "react";


export default class Size extends React.Component {
  

  handleChange (e) {
  	const size = e.target.value;
  	this.props.onChange(size);	
  }

  render() {
    return (
  	  <div class="form-group">
    		<label>Size:</label>
    		<input class="form-control" onChange={this.handleChange.bind(this)} value={this.props.value} />
  	  </div>
        
    );
  }
}
