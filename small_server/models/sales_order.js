/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  var sales_order = sequelize.define('sales_order', {
    phone_number: {
      type: DataTypes.INTEGER(15),
      allowNull: false,
      primaryKey: true
    },
    total:{
      type: DataTypes.INTEGER(10),
      allowNull: true
    },
    address:{
      type: DataTypes.STRING(50),
      allowNull: false
    },
    name:{
      type: DataTypes.STRING(10),
      allowNull: false
    }

  }, {
    tableName: 'sales_order',
    charset: 'utf8',
    collate: 'utf8_general_ci'
  });
  
 sales_order.associate = function(models){
      sales_order.belongsTo(models.store, { foreignKey: {name: 'store_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
      sales_order.belongsTo(models.user, { foreignKey: {name: 'user_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
  }

  return sales_order;
};
