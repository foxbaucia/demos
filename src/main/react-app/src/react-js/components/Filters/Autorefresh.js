import React from "react";


export default class Autorefresh extends React.Component {
  

  handleChange (e) {
    const checked = e.target.checked;
    this.props.onChange(checked);  
  }

  render() {
    return (
      <div class="form-group">
        <div class="checkbox">
          <label><input type="checkbox" onChange={this.handleChange.bind(this)} checked={this.props.value?'checked':''}/> Auto-refresh</label>
        </div>
      </div>
    );
  }
}
