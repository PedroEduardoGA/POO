import { createStackNavigator } from '@react-navigation/stack';
import Banda from './Banda';
import Bandas from './Bandas';
 
const NavegacaoBandas = createStackNavigator();
 
const TelaBandasNav = ({bandas, adicionarMusica}) => (
  <NavegacaoBandas.Navigator >
    <NavegacaoBandas.Screen name="Bandas:">
      { props => <Bandas {...props} bandas={bandas}/> }
    </NavegacaoBandas.Screen>
    <NavegacaoBandas.Screen name="Banda" options={({ route }) => ({ title: route.params.banda.banda })}>
      { props => <Banda {...props} adicionarMusica={adicionarMusica}/> }
    </NavegacaoBandas.Screen>
  </NavegacaoBandas.Navigator>
)

export default TelaBandasNav