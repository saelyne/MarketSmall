/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  var order_line_item = sequelize.define('order_line_item', {
    quantity: {
      type: DataTypes.INTEGER(4),
      allowNull: false
    },
    unitPrice: {
      type: DataTypes.INTEGER(10),
      allowNull: false
    },
    ExtendedPrice: {
      type: DataTypes.INTEGER(10),
      allowNull: false
    }
  }, {
    tableName: 'order_line_item',
    charset: 'utf8',
    collate: 'utf8_general_ci'
  });
  
 order_line_item.associate = function(models){
      order_line_item.belongsTo(models.sales_order, { foreignKey: {name: 'sales_order_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
      order_line_item.belongsTo(models.items, { foreignKey: {name: 'items_id', allowNull: false}, onDelete: 'CASCADE', onUpdate: 'CASCADE'});
  }

  return order_line_item;
};
