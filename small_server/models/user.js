/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  var user = sequelize.define('user', {
    name: {
      type: DataTypes.STRING(40),
      allowNull: false
    },
    uid: {
      type: DataTypes.CHAR(12),
      allowNull: false,
      primaryKey: true
    },
    pw: {
      type: DataTypes.STRING(128),
      allowNull: false
    },
    email: {
      type: DataTypes.STRING(40),
      allowNull: true
    },
    auth: {
      type: DataTypes.INTEGER(6),
      allowNull: false,
      defaultValue: '0'
    },
    store_id: {
      type: DataTypes.INTEGER(10),
      allowNull: true
    }
  }, {
    tableName: 'user',
    charset: 'utf8',
    collate: 'utf8_general_ci'
  });
 
  return user;
};
