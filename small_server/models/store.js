/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  var store = sequelize.define('store', {
    name: {
      type: DataTypes.STRING(40),
      allowNull: false
    }
  }, {
    tableName: 'store',
    charset: 'utf8',
    collate: 'utf8_general_ci'
  });
  
 store.associate = function(models){
      store.belongsTo(models.user, { foreignKey: {name: 'user_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
  }

  return store;
};
