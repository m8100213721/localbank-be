-- changeset author:add-columns-to-employees
ALTER TABLE t_employee
ADD COLUMN created_on TIMESTAMP,
ADD COLUMN updated_on TIMESTAMP,
ADD COLUMN created_by VARCHAR(255),
ADD COLUMN updated_by VARCHAR(255);

-- changeset author:update-timestamps-existing-rows
UPDATE t_employee SET created_on = NOW(), updated_on = NOW() WHERE created_on IS NULL OR updated_on IS NULL;

UPDATE t_employee
SET created_by = 'Admin', updated_by = 'Admin'
WHERE created_by IS NULL OR updated_by IS NULL;


ALTER TABLE t_transaction rename column paymentmethod to payment_method;

ALTER TABLE t_transaction rename column userId to user_id;

ALTER TABLE t_transaction
ADD COLUMN created_on TIMESTAMP,
ADD COLUMN updated_on TIMESTAMP,
ADD COLUMN created_by VARCHAR(255),
ADD COLUMN updated_by VARCHAR(255);

-- changeset author:update-timestamps-existing-rows
UPDATE t_transaction SET created_on = NOW(), updated_on = NOW() WHERE created_on IS NULL OR updated_on IS NULL;

UPDATE t_transaction
SET created_by = 'Admin', updated_by = 'Admin'
WHERE created_by IS NULL OR updated_by IS NULL;

--User table
ALTER TABLE t_user
ADD COLUMN created_on TIMESTAMP,
ADD COLUMN updated_on TIMESTAMP,
ADD COLUMN created_by VARCHAR(255),
ADD COLUMN updated_by VARCHAR(255);

-- changeset author:update-timestamps-existing-rows
UPDATE t_user SET created_on = NOW(), updated_on = NOW() WHERE created_on IS NULL OR updated_on IS NULL;

UPDATE t_user
SET created_by = 'Admin', updated_by = 'Admin'
WHERE created_by IS NULL OR updated_by IS NULL;
