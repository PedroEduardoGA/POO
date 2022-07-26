import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  TouchableWithoutFeedback,
  ScrollView
} from 'react-native';
 
import { colors } from './Cores';
 
export default class Bandas extends React.Component {
  navigate = (item) => {
    this.props.navigation.navigate('Banda', { banda: item })
  }
 
  render() {
    const { bandas } = this.props
    
    return (
      <ScrollView  contentContainerStyle={[!bandas.length && { flex: 1 }]}>
        <View style={[!bandas.length && { justifyContent: 'center', flex: 1 }]}>
          {
            !bandas.length && <Text style={styles.message}>Sem bandas salvas !</Text>
          }
          {
            bandas.map((item, index) => (
              <TouchableWithoutFeedback onPress={() => this.navigate(item)} key={index} >
                <View style={styles.containerBanda}>
                  <Text style={styles.txtBanda}>{item.banda}</Text>
                  <Text style={styles.txtGenero}>{item.genero}</Text>
                </View>
              </TouchableWithoutFeedback>
            ))
          }
        </View>
      </ScrollView>
    )
  }
}
 
const styles = StyleSheet.create({
  containerBanda: {
    padding: 10,
    borderBottomWidth: 2,
    borderBottomColor: colors.details,
    backgroundColor: colors.primary
  },
  txtBanda: {
    fontSize: 20,
    color: colors.background
  },
  txtGenero: {
    color: colors.secundary,
    fontStyle: 'italic'
  },
  message: {
    alignSelf: 'center',
    fontSize: 20
  }
})