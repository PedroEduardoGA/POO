import 'react-native-gesture-handler';
import React, { Component } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createMaterialBottomTabNavigator } from '@react-navigation/material-bottom-tabs';
import AddBanda from './src/AddBanda';
import TelaBandasNav from './src/TelaBandasNav';
 
const Tab = createMaterialBottomTabNavigator()
 
export default class App extends Component{
 
  state = {
    bandas: []
  }
 
  addBanda = (banda) => {
    const bandas = this.state.bandas
    bandas.push(banda)
    this.setState({ bandas })
  }

  adicionarMusica = (musica, banda) => {
    const index = this.state.bandas.findIndex(item => {
      return item.id === banda.id
    })
    
    const bandaSelected = this.state.bandas[index];
    bandaSelected.musicas.push(musica)
  
    const bandas = [
      ...this.state.bandas.slice(0, index),
      bandaSelected,
      ...this.state.bandas.slice(index + 1)
    ]
  
    this.setState({
      bandas
    })
  }

  render(){
    return(
      <NavigationContainer>
        <Tab.Navigator activeColor="lawngreen" inactiveColor="black" barStyle={{backgroundColor: 'dimgrey'}}>
          <Tab.Screen name='Adicionar Banda'>
            {props => <AddBanda {...props}
            addBanda={this.addBanda}/>}
          </Tab.Screen>
          <Tab.Screen name='Bandas'>
            {props => <TelaBandasNav {...props}
            bandas={this.state.bandas}
            adicionarMusica={this.adicionarMusica}/>}
          </Tab.Screen>
        </Tab.Navigator>
      </NavigationContainer> 
    )
  }
}