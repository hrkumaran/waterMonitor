const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {userinfo: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/getAllUserInfo'}).done(response => {
            this.setState({userinfo: response.entity._embedded.userinfo});
        });
    }

    render() {
        return (
            <Userinfo userinfos={this.state.userinfo}/>
        )
    }
}