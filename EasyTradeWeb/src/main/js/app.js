/**
 * Created by muzcategui1106 on 1/26/2017.
 */
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {users: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/user/get'}).done(response => {
            this.setState({users: response.entity._embedded.users});
        });
    }

    render() {
        return (
            <UserList users={this.state.users}/>
        )
    }
}

class UserList extends React.Component {
    render() {
        var users = this.props.users.map(user =>
            <User key={user._links.self.href} user={user}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Country</th>
                    <th>Zip code</th>
                </tr>
                {users}
                </tbody>
            </table>
        )
    }
}

class User extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.user.firstName}</td>
                <td>{this.props.user.middleName}</td>
                <td>{this.props.user.lastName}</td>
                <td>{this.props.user.adress}</td>
                <td>{this.props.user.country}</td>
                <td>{this.props.user.zipCode}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
