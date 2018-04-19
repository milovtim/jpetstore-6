Ext.Viewport.add({
    xtype: 'tabpanel',
    items: [{
        title: 'Employee Directory',
        xtype: 'grid',
        iconCls: 'x-fa fa-users',
        store: {
            data: [{
                "firstName": "Jean",
                "lastName": "Grey",
                "officeLocation": "Lawrence, KS",
                "phoneNumber": "(372) 792-6728"
            }, {
                "firstName": "Phillip",
                "lastName": "Fry",
                "officeLocation": "Lawrence, KS",
                "phoneNumber": "(318) 224-8644"
            }, {
                "firstName": "Peter",
                "lastName": "Quill",
                "officeLocation": "Redwood City, CA",
                "phoneNumber": "(718) 480-8560"
            }]
        },
        columns: [{
            text: 'First Name',
            dataIndex: 'firstName',
            flex: 1
        }, {
            text: 'Last Name',
            dataIndex: 'lastName',
            flex: 1
        }, {
            text: 'Phone Number',
            dataIndex: 'phoneNumber',
            flex: 1
        }]
    }, {
        title: 'About Sencha',
        iconCls: 'x-fa fa-info-circle'
    }]
});