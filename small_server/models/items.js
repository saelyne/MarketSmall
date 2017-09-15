/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  var items = sequelize.define('items', {
    name: {
      type: DataTypes.STRING(40),
      allowNull: false
    },
    price: {
      type: DataTypes.INTEGER(10),
      allowNull: false
    }
  }, {
    tableName: 'items',
    charset: 'utf8',
    collate: 'utf8_general_ci'
  });

  items.associate = function(models){
      items.belongsTo(models.store, { foreignKey: {name: 'store_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
  }
  


  return items;
};
